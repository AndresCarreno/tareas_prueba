import axios from 'axios';

const API = process.env.REACT_APP_BACKEND_URL + 'api/'
const getTareas = () => {
    return axios.get(`${API}tarea`)
    .then(response => response.data)
        .catch(err => console.log(err.response.data));
}

const postTarea = data => {
    return axios.post(`${API}tarea`, data)
    .then(response => response.data)
    .catch(err => console.log(err.response.data))
}

const deleteTarea = id => {
    return axios.delete(`${API}tarea/${id}`)
    .then(response => response.data)
    .catch(err => console.log(err.response.data))
}

const TareaService = {
    getTareas,
    postTarea,
    deleteTarea
}

export default TareaService;