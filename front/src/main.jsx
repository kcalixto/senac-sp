import React from 'react'
import ReactDOM from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Inicio from './pages/inicio/index.jsx';
import Listagem from './pages/listagem/index.jsx';
import Cadastro from './pages/cadastro/index.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Inicio />
  },
  {
    path: "/carros",
    element: <Listagem />
  },
  {
    path: "/carros/cadastro",
    element: <Cadastro />
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
)
