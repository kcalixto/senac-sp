import React, { useEffect, useState } from "react"
import Table from 'react-bootstrap/Table';
import { Link } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import HttpClient from '../../api/httpClient.js'

export default function Listagem() {
    const httpClient = new HttpClient()

    const [carros, setCarros] = useState([]);
    useEffect(() => {
        httpClient.getAllCars()
            .then(setCarros)
            .catch(console.log)
    }, [httpClient])

    return (
        <div>
            <div className="container mt-5">
                <h1>TADS - Atividade DSW</h1>
                <h3>Turma A 23-2 - Carros</h3>

                <hr />
                {
                    carros.length > 0 &&
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Modelo</th>
                                <th>Fabricante</th>
                                <th>Ano de Lançamento</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                carros.map((carro, index) => (
                                    <tr key={index}>
                                        <td>{carro?.id}</td>
                                        <td>{carro?.modelo}</td>
                                        <td>{carro?.fabricante}</td>
                                        <td>{carro?.anoLancamento}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </Table>
                }

                <Button variant={"primary"}>
                    <Link
                        to="/carros/cadastro"
                        style={{
                            color: 'white',
                        }}
                    >
                        Incluir novo
                    </Link>
                </Button>

                {
                    carros.length === 0 &&
                    <div style={{
                        paddingTop: "1rem",
                    }}>
                        <h3>Não há carros cadastrados.</h3>
                    </div>
                }
            </div>
        </div >
    )
};
