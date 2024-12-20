// ไฟล์: promotion.js

// รายการรูปภาพที่ต้องการแสดง
const images = ["./images/promotion/p1.jpg", "./images/promotion/p2.jpg", "./images/promotion/p3.jpg"];
let currentImageIndex = 0;

// ฟังก์ชันเปลี่ยนภาพ
function changeImage() {
    // ดึง element ที่จะแสดงภาพโดยใช้ id "slideshow-image"
    const imageElement = document.getElementById("slideshow-image");

    // ตรวจสอบว่ามี element หรือไม่
    if (imageElement) {
        // เปลี่ยน src ของรูปภาพ
        imageElement.src = images[currentImageIndex];

        // เพิ่ม index ของรูปภาพ
        currentImageIndex = (currentImageIndex + 1) % images.length; // หมุนกลับไปที่รูปแรกเมื่อหมดรายการ
    }
}

// เรียกใช้งานฟังก์ชันเปลี่ยนภาพทุก 3 วินาที
setInterval(changeImage, 3000);