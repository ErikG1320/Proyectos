import React from 'react';
//Importar componentes
import TableClientes from './TableClientes';
import Data from '../DataJson/dataclientes2024.json';

const ListarClientes = () => {
    return (
        <div>
            <TableClientes data={Data}
            titulo="Listado de Clientes"
            /> 
        </div>
    );
};

export default ListarClientes;