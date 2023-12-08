import axios from "axios";

export default class HttpClient {
    client;
    constructor() {
        this.client = axios.create({
            baseURL: "http://localhost:8080",
        })
    }

    async getAllCars() {
        return [
            {
                id: 1,
                modelo: "Uno",
                fabricante: "Fiat",
                anoLancamento: 1990,
            },
            {
                id: 2,
                modelo: "Gol",
                fabricante: "Volkswagen",
                anoLancamento: 2010,
            },
            {
                id: 3,
                modelo: "Palio",
                fabricante: "Fiat",
                anoLancamento: 2000,
            },
            {
                id: 4,
                modelo: "Celta",
                fabricante: "Chevrolet",
                anoLancamento: 2005,
            }
        ]


        const response = {
            success: true,
            data: {},
        }
        try {
            const { data } = await this.client.get(`${url}/carros`);
            response.data = data
        } catch (error) {
            response.success = false;
            response.data = {
                message: "Erro ao buscar carros",
                error: error.message,
            };
        } finally {
            return response;
        }
    }

    async getCarById(id = 0) {
        const response = {
            success: true,
            data: {},
        }

        try {
            if (!id || id === 0) {
                throw new Error("Id não informado");
            }

            const { data } = await this.client.get(`${url}/carros/${id}`);
            response.data = data
        } catch (error) {
            response.success = false;
            response.data = {
                message: "Erro ao busca um carro",
                error: error.message,
            };
        } finally {
            return response;
        }
    }

    async saveNewCar(car = {
        modelo: "",
        fabricante: "",
        anoLancamento: 0,
    }) {
        const response = {
            success: true,
            data: {},
        }

        try {
            if (Object.keys(car).length === 0) {
                throw new Error("Dados de cadastro não informados");
            }

            const { data } = await this.client.post(`${url}/carros`, car);
            response.data = data
        } catch (error) {
            console.log({ error });

            response.success = false;
            response.data = {
                message: "Erro ao busca um carro",
                error: error.message,
            };
        } finally {
            return response;
        }
    }
}

