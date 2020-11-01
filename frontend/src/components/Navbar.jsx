import React from 'react'
import Breadcrumbs from '@material-ui/core/Breadcrumbs'
import Link from '@material-ui/core/Link'

function handleClick() {
	console.log("click")
}

export default _ => {

	return (
		<div display="flex" justifyContent="center">
			<Breadcrumbs aria-label="breadcrumb">
				<Link color="inherit" href="/inicio" onClick={handleClick}>
					Material-UI
				</Link>
				<Link color="inherit" href="/inicio" onClick={handleClick}>
					Core
				</Link>
				<Link
					color="textPrimary"
					href="/components/breadcrumbs/"
					onClick={handleClick}
					aria-current="page"
				>
					Breadcrumb
				</Link>
			</Breadcrumbs>
		</div>
	)

}