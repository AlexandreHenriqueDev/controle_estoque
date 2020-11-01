import React from 'react'
import ProductTable from '~/components/ProductTable'
import Button from '@material-ui/core/Button'
import Add from '@material-ui/icons/Add'
import { makeStyles } from '@material-ui/core/styles'
import Container from '@material-ui/core/Container'
import Box from '@material-ui/core/Box'

const useStyles = makeStyles((theme) => ({
	button: {
		borderRadius: '20px'
	}
}))

export default _ => {
	const classes = useStyles()

	return (
		<Container maxWidth="md" id="home">
			<ProductTable />
			<Box width="100%" height="50vh" display="flex" justifyContent="center">
				<div>
					<Button type="submit" variant="outlined" color="primary" className={classes.button} startIcon={<Add />}>
						Adicionar
					</Button>
				</div>
			</Box>
		</Container>
	)

}