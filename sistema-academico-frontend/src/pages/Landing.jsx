import { useState } from 'react';
import "../styles/landing.css";
import RegistroAspirante from '../components/RegistroAspirante';
import LogIn from '../components/LogIn';

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
                    <LogIn/>
                </div>
            )}

            {activeTab === 'registro' && (
                <RegistroAspirante />
            )}
        </div>
    )
}