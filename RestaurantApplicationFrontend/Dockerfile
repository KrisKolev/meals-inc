FROM node:alpine AS BUILDER

WORKDIR /workdir

# Dependencies
COPY package.json /workdir/package.json
COPY package-lock.json /workdir/package-lock.json
RUN npm install

ARG buildtype

# Project sources
COPY . /workdir
RUN npm run $buildtype

FROM nginx:alpine
COPY --from=BUILDER /workdir/dist/RestaurantApplicationFrontend /usr/share/nginx/html
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
