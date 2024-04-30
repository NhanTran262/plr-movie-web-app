import { Outlet, Route, Routes } from 'react-router-dom'
import { ROUTE_DATA } from './RouterConstant.tsx'
import { RouteData } from '../utils/interface.type.ts'


export default function AppRoutes() {
  return (
    <Routes>
      {ROUTE_DATA.map((route: RouteData, index: number) => {
        const Layout = route.layout
        const Page = route.element
        return route.layout ? (
          <Route key={index} path={route.path} element={<Layout><Page /></Layout>}>
            {route.children && <Outlet />}
          </Route>
        ) : route.children ? (
          <Route key={index} path={route.path} element={<Page />}>
            {route.children.map((childRoute: RouteData, index: number) => {
              const ChildElement = childRoute.element
              return (
                <Route key={index} path={childRoute.path} element={<ChildElement />} />
              )
            })}
          </Route>
        ) : (
          <Route key={index} path={route.path} element={<Page />} />
        )
      })}
    </Routes>
  )
}