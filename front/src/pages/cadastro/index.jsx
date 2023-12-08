import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import HttpClient from "../../api/httpClient";

// Validações dos campos
function validateModelo(modelo) {
    return modelo.length < 3 || !modelo
}

function validateFabricante(fabricante) {
    return fabricante.length < 3 || !fabricante
}

function validateAnoLancamento(anoLancamento) {
    return anoLancamento < 1900 || anoLancamento > new Date().getFullYear() || !anoLancamento
}

// Executa todas as validações e retorna true se houver algum erro
function haveErrors(form, setErrors) {
    let haveErrors = false
    if (validateModelo(form.modelo)) {
        setErrors((errors) => ({ ...errors, modelo: 'Modelo inválido' }))
        haveErrors = true
    }
    if (validateFabricante(form.fabricante)) {
        setErrors((errors) => ({ ...errors, fabricante: 'Fabricante inválido' }))
        haveErrors = true
    }
    if (validateAnoLancamento(form.anoLancamento)) {
        setErrors((errors) => ({ ...errors, anoLancamento: 'Ano de lançamento inválido' }))
        haveErrors = true
    }

    return haveErrors
}

export default function Cadastro() {
    const httpClient = new HttpClient()
    const navigate = useNavigate()

    const [form, setForm] = useState({
        modelo: '',
        fabricante: '',
        anoLancamento: 0,
    })

    const [errors, setErrors] = useState({
        modelo: '',
        fabricante: '',
        anoLancamento: '',
    })

    function updateFormData(field = "", value) {
        setForm({ ...form, [field]: value })
        switch (field) {
            case "modelo": setErrors((errors) => ({ ...errors, modelo: '' })); break;
            case "fabricante": setErrors((errors) => ({ ...errors, fabricante: '' })); break;
            case "anoLancamento": setErrors((errors) => ({ ...errors, anoLancamento: '' })); break;
        }
    }

    function onSubmit(event) {
        event.preventDefault()
        if (haveErrors(form, setErrors)) return

        httpClient.saveNewCar(form)
            .then(({ success, data }) => {
                if (success) {
                    navigate("/carros", {
                        state: {
                            message: "Carro cadastrado com sucesso!"
                        }
                    })
                }

                if (!success) {
                    Object.keys(data).forEach((errorField) => {
                        console.log({ errorField });
                        setErrors((errors) => ({ ...errors, [errorField]: data[errorField] }))
                    })
                }
            })
    }

    return (
        <div style={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'flex-start',
            height: '100vh',
        }}>
            <div style={{
                display: 'flex',
                flexDirection: 'column',
                width: "min(60ch, 100%)",
                gap: '1rem',
                padding: '1rem 5rem',
            }}>
                <h1>Incluir novo Carro</h1>

                <form onSubmit={onSubmit}>
                    <Form.Group>
                        <Form.Label htmlFor="modelo">Modelo:</Form.Label>
                        <Form.Control
                            id="modelo"
                            type="text"
                            name="modelo"
                            onChange={({ target: { value } }) => value && updateFormData('modelo', value)}
                        />
                        <Form.Text style={{ color: "red", paddingBottom: '1rem' }}>
                            {errors?.modelo}
                        </Form.Text>

                        <Form.Label htmlFor="fabricante">Fabricante:</Form.Label>
                        <Form.Control
                            type="text"
                            name="fabricante"
                            id="fabricante"
                            onChange={({ target: { value } }) => value && updateFormData('fabricante', value)}
                        />
                        <Form.Text style={{ color: "red", paddingBottom: '1rem' }}>
                            {errors?.fabricante}
                        </Form.Text>

                        <Form.Label htmlFor="anoLancamento">Ano Lançamento:</Form.Label>
                        <Form.Control
                            type="number"
                            name="anoLancamento"
                            id="anoLancamento"
                            onChange={({ target: { value } }) => value && updateFormData('anoLancamento', value)}
                        />
                        <Form.Text style={{ color: "red", paddingBottom: '1rem' }}>
                            {errors?.anoLancamento}
                        </Form.Text>
                    </Form.Group>

                    <div
                        style={{
                            display: 'flex',
                            flexDirection: 'row',
                            gap: '1rem',
                            padding: '1rem 0',
                        }}
                    >
                        <Button variant={"secondary"}>
                            <Link
                                to='/carros'
                                style={{ color: 'white' }}
                            >
                                Voltar
                            </Link>
                        </Button>

                        <Button
                            type="submit"
                            variant={"success"}
                        >
                            Enviar
                        </Button>
                    </div>
                </form>
            </div>
        </div >
    )
};
