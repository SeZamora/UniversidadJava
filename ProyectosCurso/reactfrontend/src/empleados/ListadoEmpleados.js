import React, {useEffect, useState} from 'react'
import axios from 'axios';
import { NumericFormat } from 'react-number-format';

export default function ListadoEmpleados() {
    const urlBase = 'http://localhost:8080/rh-app/empleados';

    const [empleados, setEmpleados] = useState([]);

    useEffect(() => {
        cargarEmpleados();
    }, []);

    const cargarEmpleados = async () => {
        const response = await axios.get(urlBase);
        console.log("resuldato Empleados;");
        console.log(response.data);
        setEmpleados(response.data);
    }

  return (
    <div className='container'> 
        <div className="container text-center" style={{margin: "30px"}}>
            <h3>Sistemas de Recirsos Humanos</h3>
        </div>  
        <table className="table table-strped table-hover align-middle">
            <thead className='table-dark'>
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
                </tr>
            </thead>
            <tbody>
                {
                    empleados.map((empleado, indice) => (
                        <tr key={indice}>
                        <th scope="row">{empleado.idEmpleado}</th>
                        <td>{empleado.nombre}</td>
                        <td>{empleado.departamento}</td>
                        <td><NumericFormat value={empleado.sueldo} displayType={'text'} thousandSeparator="," 
                        prefix='Q' decimalScale={2} fixedDecimalScale/></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
  );
}
