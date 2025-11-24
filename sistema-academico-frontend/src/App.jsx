import { BrowserRouter, Routes, Route } from "react-router-dom";
import RegistroAspirante from "./components/RegistroAspirante";
import "./styles/global.css";
import Landing from "./pages/Landing";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        
      </Routes>
    </BrowserRouter>
  );
}
