// Write a program to read a RGB image extract 3 colur components red , green , blue 
rgb = imread("coloredChips.png");
r = rgb;
g = rgb;
b = rgb;
r(:,:,2) = 0;
r(:,:,3) = 0;
g(:,:,1) = 0;
g(:,:,3) = 0;
b(:,:,1) = 0;
b(:,:,2) = 0;
subplot(2,2,1);
imshow(rgb) ,title('rgb image');
subplot(2,2,2);
imshow(r) ,title('red component');
subplot(2,2,3);
imshow(g) ,title('green component');
subplot(2,2,4);
imshow(b) ,title('blue component');