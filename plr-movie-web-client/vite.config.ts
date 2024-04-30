import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    chunkSizeWarningLimit: 1000,
    rollupOptions: {
      output: {
        manualChunks: {
          vendor: [
            '@ant-design/icons',
            '@fortawesome/fontawesome-free',
            '@material-tailwind/react',
            '@react-oauth/google',
            '@reduxjs/toolkit',
            'axios',
            'daisyui',
            'formik',
            'preline',
            'react',
            'react-dom',
            'react-icons',
            'react-redux',
            'react-router-dom',
            'react-scroll-to-top',
            'react-share',
            'react-toastify',
            'redux',
            'tailwind-merge',
            'yup'
          ]
        }
      }
    }
  }
})
