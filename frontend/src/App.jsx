import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import SignIn from '~/views/SignIn'
import Home from '~/views/Home'
import Navbar from '~/components/Navbar'

export default props => {

	return (
		<BrowserRouter>
			<Navbar />
			<Switch>
				<Route path='/' exact={true} component={SignIn} />
				<Route path='/inicio' exact={true} component={Home} />
			</Switch>
		</BrowserRouter>
	)

}