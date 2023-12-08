import React, { useEffect, useState } from "react"
import Table from 'react-bootstrap/Table';
import { Link, useLocation } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import HttpClient from '../../api/httpClient.js'
import { Alert } from "react-bootstrap";

export default function Listagem() {
    const httpClient = new HttpClient()
    const [showAlert, setShowAlert] = useState(true)
    const { state } = useLocation()

    const [carros, setCarros] = useState({ success: false, data: [] });
    useEffect(() => {
        if (httpClient) {
            httpClient.getAllCars()
                .then(setCarros)
                .catch(console.error)
        }
    }, [])

    return (
        <div>
            <div className="container mt-5">
                <h1>TADS - Atividade DSW</h1>
                <h3>Turma A 23-2 - Carros</h3>

                {
                    state?.message &&
                    <Alert
                        variant="success"
                        onClick={() => setShowAlert((showAlert) => !showAlert)}
                        show={showAlert}>
                        {state.message}
                    </Alert>
                }

                <hr />
                {
                    carros.data.length > 0 &&
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
                                carros.data.map((carro, index) => (
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

                {
                    carros.data.length === 0 &&
                    <div style={{
                        paddingTop: "1rem",
                    }}>
                        <h3>Não há carros cadastrados.</h3>
                    </div>
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
            </div>
        </div >
    )
};
