import { LayoutProps } from '../utils/interface.type.ts'
import ClientHeader from '../components/header/ClientHeader.tsx'

export default function ClientLayout({ children }: LayoutProps) {
  return (
    <>
      <div>
        <div className='relative items-center max-h-full h-screen bg-black text-white'>
          <ClientHeader />
          <div className='fixed md:flex max-h-full h-screen max-w-full w-screen overflow-hidden'>
            <div className='overflow-y-auto h-screen w-screen'>
              {children}
            </div>
          </div>
        </div>
      </div>
    </>
  )
}