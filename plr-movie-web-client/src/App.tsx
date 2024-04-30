import { Provider } from 'react-redux'
import { store } from './app/Store.ts'
import { ThemeProvider } from '@material-tailwind/react'
import { BrowserRouter } from 'react-router-dom'
import AppRoutes from './router/AppRoutes.tsx'
import { ToastContainer } from 'react-toastify'

function App() {

  return (
    <>
      <Provider store={store}>
        <ThemeProvider>
          <BrowserRouter>
            <AppRoutes />
            <ToastContainer autoClose={3000} />
          </BrowserRouter>
        </ThemeProvider>

      </Provider>
    </>
  )
}

export default App
