import React from 'react';

const BlogPage = () => {
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

                    <div className="col-lg-4">
                        <article>

                            <div className="post-img">
                                <img src="assets/img/blog/blog-1.jpg" alt="" className="img-fluid"/>
                            </div>

                            <p className="post-category">Politics</p>

                            <h2 className="title">
                                <a href="blog-details.html">Dolorum optio tempore voluptas dignissimos</a>
                            </h2>

                            <div className="d-flex align-items-center">
                                <img src="assets/img/blog/blog-author.jpg" alt="" className="img-fluid post-author-img flex-shrink-0"/>
                                    <div className="post-meta">
                                        <p className="post-author">Maria Doe</p>
                                        <p className="post-date">
                                            <time datetime="2022-01-01">Jan 1, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                    <div className="col-lg-4">
                        <article>

                            <div className="post-img">
                                <img src="assets/img/blog/blog-2.jpg" alt="" className="img-fluid"/>
                            </div>

                            <p className="post-category">Sports</p>

                            <h2 className="title">
                                <a href="blog-details.html">Nisi magni odit consequatur autem nulla dolorem</a>
                            </h2>

                            <div className="d-flex align-items-center">
                                <img src="assets/img/blog/blog-author-2.jpg" alt="" className="img-fluid post-author-img flex-shrink-0"/>
                                    <div className="post-meta">
                                        <p className="post-author">Allisa Mayer</p>
                                        <p className="post-date">
                                            <time datetime="2022-01-01">Jun 5, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                    <div className="col-lg-4">
                        <article>

                            <div className="post-img">
                                <img src="assets/img/blog/blog-3.jpg" alt="" className="img-fluid"/>
                            </div>

                            <p className="post-category">Entertainment</p>

                            <h2 className="title">
                                <a href="blog-details.html">Possimus soluta ut id suscipit ea ut in quo quia et soluta</a>
                            </h2>

                            <div className="d-flex align-items-center">
                                <img src="assets/img/blog/blog-author-3.jpg" alt="" className="img-fluid post-author-img flex-shrink-0"/>
                                    <div className="post-meta">
                                        <p className="post-author">Mark Dower</p>
                                        <p className="post-date">
                                            <time datetime="2022-01-01">Jun 22, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                    <div className="col-lg-4">
                        <article>

                            <div className="post-img">
                                <img src="assets/img/blog/blog-4.jpg" alt="" className="img-fluid"/>
                            </div>

                            <p className="post-category">Sports</p>

                            <h2 className="title">
                                <a href="blog-details.html">Non rem rerum nam cum quo minus olor distincti</a>
                            </h2>

                            <div className="d-flex align-items-center">
                                <img src="assets/img/blog/blog-author-4.jpg" alt="" className="img-fluid post-author-img flex-shrink-0"/>
                                    <div className="post-meta">
                                        <p className="post-author">Lisa Neymar</p>
                                        <p className="post-date">
                                            <time datetime="2022-01-01">Jun 30, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                    <div class="col-lg-4">
                        <article>

                            <div class="post-img">
                                <img src="assets/img/blog/blog-5.jpg" alt="" class="img-fluid"/>
                            </div>

                            <p class="post-category">Politics</p>

                            <h2 class="title">
                                <a href="blog-details.html">Accusamus quaerat aliquam qui debitis facilis consequatur</a>
                            </h2>

                            <div class="d-flex align-items-center">
                                <img src="assets/img/blog/blog-author-5.jpg" alt="" class="img-fluid post-author-img flex-shrink-0"/>
                                    <div class="post-meta">
                                        <p class="post-author">Denis Peterson</p>
                                        <p class="post-date">
                                            <time datetime="2022-01-01">Jan 30, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                    <div class="col-lg-4">
                        <article>

                            <div class="post-img">
                                <img src="assets/img/blog/blog-6.jpg" alt="" class="img-fluid"/>
                            </div>

                            <p class="post-category">Entertainment</p>

                            <h2 class="title">
                                <a href="blog-details.html">Distinctio provident quibusdam numquam aperiam aut</a>
                            </h2>

                            <div class="d-flex align-items-center">
                                <img src="../../public/assets/img/blog/blog-1.jpg" alt="" class="img-fluid post-author-img flex-shrink-0"/>
                                    <div class="post-meta">
                                        <p class="post-author">Mika Lendon</p>
                                        <p class="post-date">
                                            <time datetime="2022-01-01">Feb 14, 2022</time>
                                        </p>
                                    </div>
                            </div>

                        </article>
                    </div>

                </div>
            </div>

        </section>
        </>
            );
};

export default BlogPage;
