import React from 'react'

export const joinCreateChat = () => {
    return (
        <div className='min-h-screen flex items-center justify-center'>
            <div className='p-10 dark: border-gray-700 border w-full flex flex-col gap-5 max-w-md rounded dark:bg-gray-900 shadow'>
                <h1 className='text-2xl font-semibold text-center'>Join Room / Create Room </h1>
                {/* name div */}
                <div className=''>
                    <label htmlFor="name" className='block font-medium mb-2'>Your Name</label>
                    <input type="text" id='name' className='w-full dark:bg-gray-600 px-4 py-2 border dark: border-gray-300 rounded-lg focus:outline-none foucs: ring-2 foucs:ring-blue-500' />
                </div>
                {/* Room Id div */}
                <div className=''>
                    <label htmlFor="name" className='block font-medium mb-2'>Room Id / New Room Id</label>
                    <input type="text" id='name' className='w-full dark:bg-gray-600 px-4 py-2 border dark: border-gray-300 rounded-lg focus:outline-none foucs: ring-2 foucs:ring-blue-500' />
                </div>

                {/* Button */}
                <div className='flex justify-center gap-2 mt-4'>
                    <button className='px-3 py-2 dark:bg-bl
                    ue-500 hover:dark:bg-blue-800 rounded-full'>Join Room</button>
                    <button className='px-3 py-2 dark:bg-orange-500 hover:dark:bg-orange-800 rounded-full'>Join Room</button>
                </div>
            </div>
        </div>
    )
}
