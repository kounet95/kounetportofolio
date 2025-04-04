import HomePage from "./pages/HomePage";
import ContactPage from "./pages/ContactPage";
import PricingPage from "./pages/PricingPage";
import ServicePage from "./pages/ServicePage";
import TeamPage from "./pages/TeamPage";
import BlogPage from "./pages/BlogPage";
import NavBarComponent from "./components/NavBarComponent";



import {BrowserRouter, useRoutes} from "react-router-dom";
import React from "react";

function App() {
    const routes = useRoutes([
        { path: '/', element: <HomePage /> },
        { path: '/contact', element: <ContactPage /> },
        { path: '/pricing', element: <PricingPage /> },
        { path: '/services', element: <ServicePage /> },
        { path: '/team', element: <TeamPage /> },
        { path: '/blog', element: <BlogPage /> },


    ]);

    return routes;
}


export default function Root() {
    return (
        <>
            <NavBarComponent />
            <BrowserRouter>
                <main className="main">
                    <App/>
                </main>
            </BrowserRouter>
        </>
);
}