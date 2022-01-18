import { render, screen } from '@testing-library/react';
import TareaService from './service/TareaService';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

test('Crear Tarea', async () => {
  const data = {
    descrip: "test tarea",
    available: true
  }
  const text = "Tarea agregada exitosamente"
  const res = await TareaService.postTarea(data);

  expect(text).toMatch(res);
    
})

test('Editar Tarea', async () => {
  const data = {
    id: 1,
    descrip: "test tarea",
    available: true
  }
  const text = "Tarea editada exitosamente"
  const res = await TareaService.postTarea(data);

  expect(text).toMatch(res);
    
})
