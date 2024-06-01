FROM node:16-alpine as build-stage

COPY . .

RUN npm install
RUN npm run build

FROM ubuntu:22.04
WORKDIR /home/ubuntu
COPY --from=0 /dist .
