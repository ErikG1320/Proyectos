import React from 'react';
// Importar componentes
import ListarClientes from "./Component/ListarClientes";
import Clientes_Pais from "./Component/Clientes_Pais";

function App() {
  return (
    <div className="container">
      <ListarClientes />
      <hr/>
      <Clientes_Pais/>
    </div>
  );
}

export default App;
