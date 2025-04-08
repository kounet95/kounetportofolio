import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { fetchArticles } from '../actions/articleActions';

const BlogPage = () => {
    const dispatch = useDispatch();
    const { articles, loading, error } = useSelector(state => state.articles);
    useEffect(() => {
        dispatch(fetchArticles());
    }, [dispatch]);
    return (
        <>
            <div className="page-title">
                <div className="heading">
                    <div className="container">
                        <div className="row d-flex justify-content-center text-center">
                            <div className="col-lg-8">
                                <h1>Blog</h1>
                                <p className="mb-0">Odio et unde deleniti. Deserunt numquam exercitationem. Officiis quo
                                    odio sint voluptas consequatur ut a odio voluptatem. Sit dolorum debitis veritatis natus
                                    dolores. Quasi ratione sint. Sit quaerat ipsum dolorem.</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <section id="blog-posts" className="blog-posts section ">

            <div className="container ">
                <div className="row gy-4 ">

                  
                {articles.map(article => (

                    <div  key={article.id} class="col-lg-4">
                        <article>

                            <div class="post-img">
                                <img src="assets/img/blog/blog-6.jpg" alt="" class="img-fluid"/>
                            </div>

                            <p class="post-category">{article.title}</p>

                            <h2 class="title">
                                <a href={`/blog/${article.id}`}>{article.content}</a>
                            </h2>

                            <div class="d-flex align-items-center">
                                <img src="../../public/assets/img/blog/blog-1.jpg" alt="" class="img-fluid post-author-img flex-shrink-0"/>
                                    <div class="post-meta">
                                        <p class="post-author">{article.author}</p>
                                        <p class="post-date">
                                            <time datetime="2022-01-01">{article.createdAt}</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>
                ))}
                </div>
            </div>

        </section>
        </>
            );
};

export default BlogPage;
