import { useState } from 'react';
import RegistroAspirante from '../components/RegistroAspirante';

export default function Landing() {
    const [activeTab, setActiveTab] = useState('login');

    return (
        <div className="container">
            <div className="tabs">
                <button 
                    className={activeTab === 'login' ? 'active' : ''}
                    onClick={() => setActiveTab('login')}
                >
                    Iniciar Sesion
                </button>
                <button 
                    className={activeTab === 'registro' ? 'active' : ''}
                    onClick={() => setActiveTab('registro')}
                >
                    Registrarse
                </button>
            </div>

            {activeTab === 'login' && (
                <div className="form-container">
                    {/* Tu componente de login aquí */}
                    <p>Formulario de Iniciar Sesión</p>
                </div>
            )}

            {activeTab === 'registro' && (
                <RegistroAspirante />
            )}
        </div>
    )
}