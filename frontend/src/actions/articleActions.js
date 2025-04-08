// actions/articlesActions.js
import axios from 'axios';

// URL de l'API
const API_URL = 'http://localhost:8888/BLOGSERVICE/api/blog/articles/all';

// Action Types
export const FETCH_ARTICLES = 'FETCH_ARTICLES';
export const CREATE_ARTICLE = 'CREATE_ARTICLE';
export const UPDATE_ARTICLE = 'UPDATE_ARTICLE';
export const DELETE_ARTICLE = 'DELETE_ARTICLE';
export const SET_LOADING = 'SET_LOADING';
export const SET_ERROR = 'SET_ERROR';

// Actions
export const fetchArticles = () => async (dispatch) => {
    dispatch({ type: SET_LOADING, payload: true });
    try {
        const response = await axios.get(API_URL);
        dispatch({ type: FETCH_ARTICLES, payload: response.data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    } finally {
        dispatch({ type: SET_LOADING, payload: false });
    }
};

export const createArticle = (articleData) => async (dispatch) => {
    try {
        const response = await axios.post(API_URL, articleData);
        dispatch({ type: CREATE_ARTICLE, payload: response.data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const updateArticle = (id, articleData) => async (dispatch) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, articleData);
        dispatch({ type: UPDATE_ARTICLE, payload: response.data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const deleteArticle = (id) => async (dispatch) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
        dispatch({ type: DELETE_ARTICLE, payload: id });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};
