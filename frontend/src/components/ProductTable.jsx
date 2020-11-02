import React, { useState, useEffect } from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import IconButton from '@material-ui/core/IconButton';
import Edit from '@material-ui/icons/Edit';
import Remove from '@material-ui/icons/Remove';
import Add from '@material-ui/icons/Add';
import Check from '@material-ui/icons/Check';
import Modal from '@material-ui/core/Modal';
import Close from '@material-ui/icons/Close';

import { getAll, save, remove, editar } from '~/services/produtos.service';

import CardEdit from '~/components/CardEdit';

const useStyles = makeStyles({
	table: {
		minWidth: 650,
	},
	button: {
		borderRadius: '20px',
		minWidth: '140px',
		margin: '1px 0'
	},
	modal: {
		display: 'flex',
		alignItems: 'center',
		justifyContent: 'center',
	},
});

function randomCod() {
	return Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);
}

export default _ => {
	const classes = useStyles();
	const [newElem, setNewElem] = useState(false)
	const [produtoAdd, setProduto] = useState({
		codigo: randomCod(),
		nome: '',
		preco: null,
		quantidade: 0
	})

	const [produtos, setProdutos] = useState()
	useEffect(async => {
		getAll().then(response => {
			setProdutos(response.data);
		})
	}, [])

	function saveProduct() {

		setNewElem(false)
		save(produtoAdd).then(response => {
			setProdutos(response.data);
		})

	}

	function removeProduct(prod) {

		remove(prod).then(response => {
			setProdutos(response.data);
		})

	}

	const [open, setOpen] = useState(false);
	const [produtoEdit, setProdutoEdit] = useState(null);

	const handleOpen = (o, p) => {
		setOpen(o);
		setProdutoEdit(p);
	};

	const handleClose = () => {
		setOpen(false);
	};

	const handleEditProd = prod => {
		setProdutoEdit(prod)
		setOpen(false)
		editar(prod).then(response => {
			setProdutos(response.data);
		})
	}

	function addRegion() {
		if (newElem) {
			return (
				<TableRow key={'new'}>
					<TableCell component="th" scope="row">
						<TextField
							id="standard-textarea"
							label="Nome"
							placeholder="Nome do produto"
							variant="outlined"
							size="small"
							onChange={e => setProduto({ ...produtoAdd, nome: e.target.value })}
						/>
					</TableCell>
					<TableCell align="right">
						<TextField
							id="outlined-number"
							label="Preço"
							type="number"
							size="small"
							InputLabelProps={{
								shrink: true,
							}}
							variant="outlined"
							onChange={e => setProduto({ ...produtoAdd, preco: e.target.value })}
							step='0.01'
						/>
					</TableCell>
					<TableCell align="right">
						<TextField
							id="outlined-number"
							label="Quantidade"
							type="number"
							size="small"
							InputLabelProps={{
								shrink: true,
							}}
							variant="outlined"
							onChange={e => setProduto({ ...produtoAdd, quantidade: e.target.value })}
						/>
					</TableCell>
					<TableCell align="right">
						<Button type="submit" size="small" color="primary" disabled={!produtoAdd || !produtoAdd.nome || !produtoAdd.preco || !produtoAdd.quantidade} variant="outlined" className={classes.button} startIcon={<Check />} onClick={_ => saveProduct()}>
							Salvar
							</Button>
						<Button type="submit" size="small" variant="outlined" color="secondary" className={classes.button} startIcon={<Close />} onClick={_ => setNewElem(false)}>
							Cancelar
							</Button>
					</TableCell>
				</TableRow>
			)
		} else {
			return (
				<></>
			)
		}
	}

	function buttonAdd() {
		if (!newElem) {
			return (
				<Button
					size="small"
					type="submit"
					color="primary"
					className={classes.button}
					startIcon={<Add />}
					onClick={_ => setNewElem(true)}
					style={{ width: '100%' }}
				>
					Adicionar
				</Button>
			)
		}
		else return (<></>)
	}

	return (
		<>
			<TableContainer component={Paper} align="center">
				<Table className={classes.table} aria-label="simple table">
					<TableHead>
						<TableRow>
							<TableCell>
								<h3>
									Nome do produto
								</h3>
							</TableCell>
							<TableCell align="left">
								<h3>
									Preço
								</h3>
							</TableCell>
							<TableCell align="left">
								<h3>
									Quantidade em estoque
								</h3>
							</TableCell>
							<TableCell align="right">
								<h3>
									Ações
								</h3>
							</TableCell>
						</TableRow>
					</TableHead>
					<TableBody>
						{produtos ? produtos.map((row) => (
							<TableRow key={row.codigo}>
								<TableCell component="th" scope="row">
									{row.nome}
								</TableCell>
								<TableCell align="left">{row.preco}</TableCell>
								<TableCell align="left">{row.quantidade}</TableCell>
								<TableCell align="right">
									<IconButton size="small" color="primary" aria-label="add" onClick={_ => handleOpen(true, row)}>
										<Edit />
									</IconButton>
									<IconButton size="small" color="secondary" aria-label="add" onClick={_ => removeProduct(row)}>
										<Remove />
									</IconButton>
								</TableCell>
							</TableRow>
						)) : []}
						{addRegion()}
					</TableBody>
				</Table>
				{buttonAdd()}
			</TableContainer>
			<Modal
				open={open}
				onClose={handleClose}
				aria-labelledby="simple-modal-title"
				aria-describedby="simple-modal-description"
				className={classes.modal}
			>
				<CardEdit produto={produtoEdit || produtoAdd} editProd={handleEditProd} alterProd={setProdutoEdit} close={setOpen} />
			</Modal>
		</>
	)

}