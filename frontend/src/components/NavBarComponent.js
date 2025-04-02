import React from 'react';

const NavBarComponent = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-secondary ">
            <div className="container-fluid d-flex justify-content-evenly mainNav opacity-50">
                <a className="navbar-brand " href="/">Accueil</a>
                <a className="navbar-brand" href="/services">Services</a>
                <a className="navbar-brand" href="/team">Equipe</a>
                <a className="navbar-brand" href="/blog">Blog</a>
                <a className="navbar-brand" href="/pricing">Pricing</a>
                <a className="navbar-brand" href="/contact">Contact</a>



                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>


            </div>
        </nav>
    );
};

export default NavBarComponent;
