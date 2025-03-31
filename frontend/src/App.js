import logo from './logo.svg';
import './App.css';
import HomePage from "./pages/HomePage";
import ContactPage from "./pages/ContactPage";
import PricingPage from "./pages/PricingPage";
import ServicePage from "./pages/ServicePage";
import TeamPage from "./pages/TeamPage";
import {BrowserRouter, useRoutes} from "react-router-dom";
import React from "react";

function App() {
    const routes = useRoutes([
        { path: '/', element: <HomePage /> },
        { path: '/contact', element: <ContactPage /> },
        { path: '/pricing', element: <PricingPage /> },
        { path: '/service', element: <ServicePage /> },
        { path: '/team', element: <TeamPage /> },

    ]);

    return routes;  // `useRoutes` retourne le JSX des routes définies
}


export default function Root() {
    return (
        <>
        <h1> Header</h1>
            <BrowserRouter>
            <App />
        </BrowserRouter>
        </>
    );
}