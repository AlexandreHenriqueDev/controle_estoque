import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import SignIn from '~/views/SignIn'
import Home from '~/views/Home'

export default props => {

	return (
		<BrowserRouter>
			<Switch>
				<Route path='/' exact={true} component={SignIn} />
				<Route path='/inicio' exact={true} component={Home} />
			</Switch>
		</BrowserRouter>
	)

}