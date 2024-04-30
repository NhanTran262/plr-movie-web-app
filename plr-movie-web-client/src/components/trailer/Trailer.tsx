import { Button, Carousel, Typography } from '@material-tailwind/react'
import { TrailerMenu } from '../../utils/interface.type.ts'
import { FaPlay } from 'react-icons/fa'
import { BsExclamationCircle } from 'react-icons/bs'

export default function Trailer() {
  const trailerMenus: TrailerMenu[] = [
    {
      id: 1,
      name: 'Trò chơi kim tự tháp',
      link: 'https://img.phimmoichillq.net/images/info/pyramid-game.jpg'
    },
    {
      id: 2,
      name: 'Dune: Hành tinh cát - Phần hai',
      link: 'https://img.phimmoichillq.net/images/info/dune-part-two.jpg'
    },
    {
      id: 3,
      name: 'Alienoid 2: Đa Chiều Hỗn Chiến',
      link: 'https://img.phimmoichillq.net/images/info/alienoid-return-to-the-future.jpg'
    }
  ]
  return (
    <>
      <Carousel
        loop={true}
        autoplay={true}
        autoplayDelay={10000}
        transition={{ duration: 1 }}
        navigation={({ setActiveIndex, activeIndex, length }) => (
          <div className='absolute bottom-4 left-2/4 z-50 flex -translate-x-2/4 gap-2'>
            {new Array(length).fill('').map((_, i) => (
              <span
                key={i}
                className={`block h-1 w-1 cursor-pointer rounded-full transition-colors content-['']
                ${activeIndex === i ? 'bg-white' : 'bg-white/50'}`}
                onClick={() => setActiveIndex(i)}
              />
            ))}
          </div>
        )}
      >
        {trailerMenus.map((trailer) => (
          <div className='relative w-full h-full'>
            <img key={trailer.id} src={trailer.link} alt={trailer.name} className='w-full h-full object-bottom' />
            <div className='absolute inset-y-2/3  h-16 pl-4 place-items-center'>
              <div className='w-full text-start'>
                <Typography
                  variant='h1'
                  color='white'
                  className='text-5xl'
                >{trailer.name}
                </Typography>
                <div className='flex justify-start gap-2 py-2'>
                  <Button size='lg' color='white' className='flex items-center gap-2 rounded-lg'>
                    <FaPlay className='text-xl' />
                    <span> Xem ngay</span>
                  </Button>
                  <Button size='lg' className='bg-gray-800 flex items-center gap-2 rounded-lg'>
                    <BsExclamationCircle className='text-xl'/>
                    <span>Chi tiết</span>
                  </Button>
                </div>
              </div>
            </div>
          </div>
        ))}
      </Carousel>
    </>
  )
}