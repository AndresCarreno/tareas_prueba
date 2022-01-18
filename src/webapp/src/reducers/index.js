const reducer = (state, actions) =>{
    if(reducerObject(state, actions)[actions.type]){
        return reducerObject(state, actions)[actions.type];
    }else{
        return state;
    }
}

const reducerObject = (state, actions) =>({
    'ADD_TAREA' : {
        ...state,
        tarea : [...state.tarea, actions.payload]
    },
    'DELETE_TAREA' : {
        ...state,
        tarea: state.tarea.filter(t => t.id !== actions.payload)
    },
    'GET_TAREAS' : {
        ...state,
        tarea : actions.payload
    }

})

export default reducer;