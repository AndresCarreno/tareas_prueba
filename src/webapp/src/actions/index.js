export const addTarea = payload => ({
    type : 'ADD_TAREA',
    payload,
})

export const deleteTarea = payload => ({
    type: 'DELETE_TAREA',
    payload,
})

export const getTareas = payload => ({
    type: 'GET_TAREAS',
    payload,
})