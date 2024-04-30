import Content from '../../../components/content/Content.tsx'

export default function ClientHomePage() {
  return (
    <>
      <div className='relative md:flex h-screen w-full overflow-hidden'>
        <div className='flex-wrap w-full h-screen'>
          <Content />
        </div>
      </div>

    </>
  )
}