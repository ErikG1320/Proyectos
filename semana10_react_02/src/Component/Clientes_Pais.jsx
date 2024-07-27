import React, { useState } from 'react';
import TableClientes from './TableClientes';
import Data from '../DataJson/dataclientes2024.json';

const Clientes_Pais = () => {
    const [pais, setPais] = useState('');
    const [clientesFiltrados, setClientesFiltrados] = useState([]);

    const handlerpais = (e) => {
        setPais(e.target.value);
    };

    const query = (e) => {
        e.preventDefault();
        // Filtrar los clientes según el país
        const clientesPorPais = Data.filter((cliente) =>
            cliente.pais.toLowerCase().includes(pais.toLowerCase())
        );
        setClientesFiltrados(clientesPorPais);
    };

    return (
        <div>
            <p>
                Nombre del País: <input type="text" name="pais" value={pais} onChange={handlerpais} />
                <button onClick={query}>Buscar</button>
            </p>
            <TableClientes data={clientesFiltrados} titulo={`Clientes del país: ${pais} - Json`} />
        </div>
    );
};

export default Clientes_Pais;
