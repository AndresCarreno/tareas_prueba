import React from "react";
import { connect } from "react-redux";
import { Container } from "reactstrap";
import { addTarea, deleteTarea, getTareas } from "./actions"

import Tarea from "./components/Tarea";
import TareaForm from "./components/TareaForm";

import TareaService from "./service/TareaService";

function App(props) {
  const {tarea} = props;

  const [modal, setModal] = React.useState(false);
  const [defaultValue, setDefaultValue] = React.useState({
      descrip : '',
      available : true,
  })

  const newTask = () => {
    setDefaultValue({
      descrip : '',
      available : true,
    });
    toggle();
  }
  const handleAddTarea = async task => {
    try{
      
      const res = await TareaService.postTarea(task);
      alert(res)
      handleGetTareas();

    }catch(err){
      alert('Algo ocurrió');
      console.log(err);
    }
  }

  const handleDeleteTarea = (taskId) => {
    try{

      props.deleteTarea(taskId)
      TareaService.deleteTarea(taskId).then(r => console.log(r));
    }catch(err){
      alert('No se puedo eliminar');
      console.log(err)
    }
  }

  const handleEditTarea = (task) => {
    console.log("cur tarea", task)
    setDefaultValue({
      ...task, 
      id: task.id})
      toggle();
    
  }

  const handleGetTareas = async () => {
   await TareaService.getTareas().then(r => props.getTareas(r));
  }

  const toggle = () => {
    setModal(!modal)
}

  React.useEffect(() => {
    handleGetTareas();
  }, []);

  return (
    <div className="App">
      
      <Container>
        <TareaForm 
          handleAddTarea={handleAddTarea}  
          toggle={toggle} 
          modal={modal}
          defaultValue={defaultValue}
          newTask={newTask}
          />
        <Tarea tarea={tarea} 
          handleDeleteTarea={handleDeleteTarea}
          handleEditTarea={handleEditTarea}
          />
      </Container>
        
    </div>
  );
}

const mapStateToProps = state => {
  return{
    tarea : state.tarea
  }
}

const mapDispatchToProps = {
  addTarea,
  deleteTarea,
  getTareas
}
export default connect(mapStateToProps, mapDispatchToProps)(App);
