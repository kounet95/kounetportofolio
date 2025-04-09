// src/components/BlogFormPage.js
import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { createArticle } from '../actions/articleActions';
import HeaderComponent from '../components/HeaderComponent';

const BlogFormPage = () => {
    const dispatch = useDispatch();
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [author, setAuthor] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        const newArticle = { title, content, author };
        dispatch(createArticle(newArticle));
    };

    return (
        <>
        <div className="page-title" data-aos="fade">
            <HeaderComponent title = "Nouvel article"/>
            <nav className="breadcrumbs">
                <div className="container">
                    <ol>
                    <li><a href="/">Home</a></li>
                    <li><a href="/blog">Blog</a></li>
                    <li className="current">Nouvel article</li>
                    </ol>
                </div>
            </nav>
        </div>
        <div className="container">
            <div className="row">
                <div className="col-lg-8">
                    <section id="blog-details" className="blog-details section">
                        <div className="container">
                            <article className="article">
                                <form onSubmit={handleSubmit}  className="form-group">
                                    <div className="form-group">
                                        <label>Title</label>
                                        <input type="text"  className="form-control" value={title} onChange={(e) => setTitle(e.target.value)} />
                                    </div>
                                    <div className="form-group">
                                        <label>Content</label>
                                        <textarea  className="form-control" value={content} onChange={(e) => setContent(e.target.value)} />
                                    </div>
                                    <div className="form-group">
                                        <label>Author</label>
                                        <input  className="form-control" type="text" value={author} onChange={(e) => setAuthor(e.target.value)} />
                                    </div>
                                    <button type="submit" className="btn btn-primary">Create Article</button>
                                </form>
                            </article>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        </>
    );
};

export default BlogFormPage;
