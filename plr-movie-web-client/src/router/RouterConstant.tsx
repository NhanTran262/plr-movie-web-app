import ClientLayout from '../layout/ClientLayout.tsx'
import ClientHomePage from '../layout/pages/home/ClientHomePage.tsx'
import { RouteData } from '../utils/interface.type.ts'
import ClientLivePage from '../layout/pages/live/ClientLivePage.tsx'
import ClientHboPage from '../layout/pages/hbo/ClientHboPage.tsx'
import ClientBabyPage from '../layout/pages/baby/ClientBabyPage.tsx'

export const ROUTE_DATA: RouteData[] = [
  { path: '/', element: ClientHomePage, layout: ClientLayout },
  { path: '/live', element: ClientLivePage, layout: ClientLayout },
  { path: '/hbo', element: ClientHboPage, layout: ClientLayout },
  { path: '/baby', element: ClientBabyPage, layout: ClientLayout }
]