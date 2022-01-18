
const text = "Hola Mundo";

test('Debe tener texto', () =>{
    expect(text).toMatch(/Mundo/);
})