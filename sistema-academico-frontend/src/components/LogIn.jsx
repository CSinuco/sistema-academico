import "../styles/forms.css";
import { useState } from "react";

export default function LogIn() {
    const [form, setForm] = useState({
        usuario: "",
        contrasena: "",
      });
    
      const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
      };
    return(
    <div className="center-container">
      <div className="card form-card">
        <h2 className="title">Iniciar Sesion</h2>

        <form className="form">
          
          <input
            type="text"
            name="usuario"
            placeholder="Nombre de usuario"
            onChange={handleChange}
            className="input"
          />

          <input
            type="text"
            name="contrasena"
            placeholder="Contraseña"
            onChange={handleChange}
            className="input"
          />

          

          <button type="submit" className="primary-btn full">
            Iniciar Sesion
          </button>
        </form>
      </div>
    </div>
    )
}