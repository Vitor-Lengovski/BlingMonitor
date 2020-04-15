// function addImageInput(e, element) {
//     e.preventDefault()

//     console.log('aa')
//     $('.add-input-button').remove()
//     $('.inputs-container').append(
//         `<div class="input-video-container">
//         <div class="camera-indication"><img src="images/camera.svg" alt=""></div>
//             <input type="url" name="image-input" class="image-input">

//             <button class="add-input-button" onclick="addImageInput(event, this)">+</button>
//             <button class="rm-input-button" >-</button>
//         </div>`
//     )
// }

// function submitImages(){
//     $('.input-video-container').each(function(){
//         let imageUrl = $(this).children('.image-inputs').text()
//         $('.all-images-container').append(`<div class="video-container">
//         <iframe src='${imageUrl}' allowfullscreen frameborder="0"></iframe>
//     </div>`
//         )
//     })
// }