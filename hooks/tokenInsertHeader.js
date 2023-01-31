import axios from 'axios';

export const tokenInsertHeader = (token) => {
    if (!token) return false
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    return true
}