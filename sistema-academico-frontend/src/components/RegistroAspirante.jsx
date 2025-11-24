import { useState } from "react";
import "../styles/forms.css";

export default function RegistroAspirante() {
  const [form, setForm] = useState({
    nombre: "",
    apellido: "",
    correo: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const submitForm = async (e) => {
    e.preventDefault();

    const res = await fetch("http://localhost:8080/api/aspirantes/registro", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(form)
    });

    const data = await res.json();
    console.log(data);
    alert(`Usuario creado: ${data.username}\nToken: ${data.token}`);
  };

  return (
    <div className="center-container">
      <div className="card form-card">
        <h2 className="title">Registro del Aspirante</h2>

        <form onSubmit={submitForm} className="form">
          
          <input
            type="text"
            name="nombres"
            placeholder="Nombres"
            onChange={handleChange}
            className="input"
          />

          <input
            type="text"
            name="apellidos"
            placeholder="Apellidos"
            onChange={handleChange}
            className="input"
          />

          <input
            type="email"
            name="correo"
            placeholder="Correo electrónico"
            onChange={handleChange}
            className="input"
          />

          <button type="submit" className="primary-btn full">
            Registrar Aspirante
          </button>
        </form>
      </div>
    </div>
  );
}
