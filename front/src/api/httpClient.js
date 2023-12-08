import axios from "axios";

export default class HttpClient {
    client;
    constructor() {
        this.client = axios.create({
            baseURL: "http://localhost:8080",
            headers: {
                "Content-Type": "application/json",
            }
        })
    }

    async getAllCars() {
        const response = {
            success: true,
            data: {},
        }
        try {
            const { data } = await this.client.get("/carros");
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

            const { data } = await this.client.get(`/carros/${id}`);
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

            const { data } = await this.client.post("/carros/cadastro", car);
            response.data = data
        } catch (error) {
            response.success = false;

            if (error?.code === "ERR_BAD_REQUEST") {
                const validationErrors = error?.response?.data?.errors;
                if (validationErrors?.length > 0) {
                    validationErrors.forEach(err => {
                        response.data[err.field] = err.defaultMessage;
                    });

                    return response
                }
            }

            response.data = {
                message: "Erro ao salvar o novo carro",
                error: error.message,
            };
        } finally {
            return response;
        }
    }
}

