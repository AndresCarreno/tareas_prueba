import React from "react";
import {Modal, Button, ModalHeader, ModalBody, ModalFooter, Form, FormGroup, Label, Input} from 'reactstrap';

function TareaForm ({handleAddTarea, toggle, modal, defaultValue, newTask}){
    
    const [form, setValue] = React.useState({...defaultValue})

  

    const handleInput = event => {
        console.log(form)
        setValue({
            ...form,
            [event.target.name] : event.target.value
        })
    }

    const handleSubmit = event => {
        event.preventDefault();
        console.log(form);
        if(form.descrip === ''){
            alert('Agregue descripción')
            return false;
        }

        handleAddTarea(form);
        toggle();
    }

    React.useEffect(() =>{
        setValue({...defaultValue})
    }, [defaultValue])
    
    return(
        <div className="mt-5 mb-4">
            <center>
                <Button
                color="primary"
                onClick={newTask}
                >
                Agregar Tarea
                </Button>
            </center>
        {modal &&
            <Modal
                isOpen={modal}
                toggle={toggle}
            >
                <ModalHeader 
                    toggle={toggle}
                >
                  Agregar Tarea
                </ModalHeader>
                <ModalBody>
                    <Form onSubmit={handleSubmit}>
                        <Input 
                            id='id'
                            name='id'
                            onChange={handleInput}
                            hidden={true}
                            defaultValue={defaultValue.id}
                        />
                        <FormGroup>
                            <Label >Descripción</Label>
                            <Input
                                id='descrip'
                                name='descrip'
                                onChange={handleInput}
                                defaultValue={defaultValue.descrip}
                            />
                        </FormGroup>
                    </Form>
                </ModalBody>
                <ModalFooter>
                    <Button
                    color="primary"
                    onClick={handleSubmit}
                    >
                    Realizar
                    </Button>
                    {' '}
                    <Button onClick={toggle}>
                    Cancel
                    </Button>
                </ModalFooter>
            </Modal>
            }
      </div>
    )
}

export default TareaForm;