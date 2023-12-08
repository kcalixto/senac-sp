import React from "react";
import "./styles.css"

export default function Inicio() {
    return (
        <div>
            <h1>Listagem e inclusão de carros</h1>
            <h2>TADS Atividade Desenvolvimento Web 2023-2 - Turma A</h2>
            <p>Nome completo: <strong>Kauã Chaves Calixto</strong></p>
            <p>Está cursando PI4 neste semestre? <strong>SIM</strong></p>
            <p>Observações:<br />
                <em>Para rodar o front-end do projeto: cd front && npm run dev</em>
            </p>
            <p>
                <a href="/carros">Link para tela de listagem das carros</a>
            </p>
        </div>
    )
};
