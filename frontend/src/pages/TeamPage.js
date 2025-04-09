import React from 'react';
import HeaderComponent from '../components/HeaderComponent';

const TeamPage = () => {
    return (
            <div className="page-title" data-aos="fade">
                <HeaderComponent title="Equipe" />
                <nav className="breadcrumbs">
                    <div className="container">
                        <ol>
                        <li><a href="/">Home</a></li>
                        <li className="current">Equipe</li>
                        </ol>
                    </div>
                </nav>
            </div>
    );
};

export default TeamPage;
