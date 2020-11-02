import axios from 'axios'

const url = 'http://localhost:9090/api/controle/'

export function getAll() {

	return axios.get(url + 'estoque/')
}

export function save(produto) {

	return axios.post(url + 'estoque/novo', {...produto})

}

export function remove(produto) {

	return axios.post(url + 'estoque/remover', {...produto})

}

export function editar(produto) {

	return axios.post(url + 'estoque/editar', {...produto})

}