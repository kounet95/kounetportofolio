import React from 'react';

const NavBarComponent = () => {
    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-secondary ">
            <div className="container-fluid d-flex justify-content-evenly mainNav opacity-50 dropdown">
                <a className="navbar-brand " href="/">Accueil</a>
                <a className="navbar-brand" href="/services">Services</a>
                <a className="navbar-brand" href="/team">Equipe</a>
                <a className="navbar-brand dropbtn " href="/blog">Blog</a>
                <div className="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="/blog/new">nouveau</a>
                    <a href="#">Link 3</a>
                </div>
                <a className="navbar-brand" href="/pricing">Pricing</a>
                <a className="navbar-brand" href="/contact">Contact</a>
                <a className="navbar-brand" href="/signin">Login</a>


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
