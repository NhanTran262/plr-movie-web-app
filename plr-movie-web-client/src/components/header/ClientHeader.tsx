import { PiBaby, PiTelevision } from 'react-icons/pi'
import { SiHbo } from 'react-icons/si'
import { MenuItem } from '../../utils/interface.type.ts'
import { useLocation, useNavigate } from 'react-router-dom'
import { twMerge } from 'tailwind-merge'
import { GoHome } from 'react-icons/go'

export default function ClientHeader() {
  const navigate = useNavigate()
  const location = useLocation()
  const pathname: string = location.pathname
  const menus: MenuItem[] = [
    {
      icon: <GoHome />,
      title: 'Home',
      url: '/',
      active: '/' === pathname

    },
    {
      icon: <PiTelevision />,
      title: 'Live',
      url: '/live',
      active: '/live' === pathname

    },
    {
      icon: <SiHbo />,
      title: 'HBO',
      url: '/hbo',
      active: '/hbo' === pathname

    },
    {
      icon: <PiBaby />,
      title: 'Baby',
      url: '/baby',
      active: '/baby' === pathname

    }

  ]
  return (
    <>
      <div className='h-16 w-full text-white'>
        <div className='px-6 flex text-center justify-start gap-10 items-center text-xl py-2'>
          {menus.map((menu, index) => (
            <div key={index}
                 className={twMerge('flex gap-2 items-center text-gray-400 hover:text-gray-500 py-3 px-5 mb-2 cursor-pointer', menu.active && 'text-white font-semibold')}
                 onClick={() => navigate(menu.url)}>
              <span>{menu.icon}</span>
              <p>{menu.title}</p>
            </div>
          ))}
        </div>
      </div>
    </>
  )
}