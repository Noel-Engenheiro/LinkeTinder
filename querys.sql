PGDMP     )    +            	    z            Banco de Dados LinkeTinder     11.17 (Debian 11.17-1.pgdg100+1)    15.0 (Debian 15.0-1.pgdg100+1) 4    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    Banco de Dados LinkeTinder    DATABASE     �   CREATE DATABASE "Banco de Dados LinkeTinder" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pt_BR.UTF-8';
 ,   DROP DATABASE "Banco de Dados LinkeTinder";
                postgres    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                postgres    false            �           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    6            �            1259    16470    cadastro_empresa    TABLE     1  CREATE TABLE public.cadastro_empresa (
    cod_empresa integer NOT NULL,
    nome character varying(50) NOT NULL,
    e_mail character varying(100),
    descricao_pessoal text NOT NULL,
    pais_empresa character varying(50),
    cep integer,
    senha character varying(120) NOT NULL,
    cnpj bigint
);
 $   DROP TABLE public.cadastro_empresa;
       public            postgres    false    6            �            1259    16468     cadastro_empresa_cod_empresa_seq    SEQUENCE     �   CREATE SEQUENCE public.cadastro_empresa_cod_empresa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.cadastro_empresa_cod_empresa_seq;
       public          postgres    false    201    6            �           0    0     cadastro_empresa_cod_empresa_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.cadastro_empresa_cod_empresa_seq OWNED BY public.cadastro_empresa.cod_empresa;
          public          postgres    false    200            �            1259    16484    candidato_competencia    TABLE     ^   CREATE TABLE public.candidato_competencia (
    cod_candidato_competencia integer NOT NULL
);
 )   DROP TABLE public.candidato_competencia;
       public            postgres    false    6            �            1259    16482 3   candidato_competencia_cod_candidato_competencia_seq    SEQUENCE     �   CREATE SEQUENCE public.candidato_competencia_cod_candidato_competencia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 J   DROP SEQUENCE public.candidato_competencia_cod_candidato_competencia_seq;
       public          postgres    false    6    203            �           0    0 3   candidato_competencia_cod_candidato_competencia_seq    SEQUENCE OWNED BY     �   ALTER SEQUENCE public.candidato_competencia_cod_candidato_competencia_seq OWNED BY public.candidato_competencia.cod_candidato_competencia;
          public          postgres    false    202            �            1259    16387 
   candidatos    TABLE     �  CREATE TABLE public.candidatos (
    cod_candidato integer NOT NULL,
    nome character varying(200) NOT NULL,
    sobrenome character varying(50) NOT NULL,
    data_de_nascimento date NOT NULL,
    e_mail character varying(100) NOT NULL,
    cpf character(11) NOT NULL,
    pais character varying(50) NOT NULL,
    cep bigint NOT NULL,
    descricao_pessoal text NOT NULL,
    senha character varying(16) NOT NULL
);
    DROP TABLE public.candidatos;
       public            postgres    false    6            �            1259    16385    candidatos_cod_candidato_seq    SEQUENCE     �   CREATE SEQUENCE public.candidatos_cod_candidato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.candidatos_cod_candidato_seq;
       public          postgres    false    197    6            �           0    0    candidatos_cod_candidato_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.candidatos_cod_candidato_seq OWNED BY public.candidatos.cod_candidato;
          public          postgres    false    196            �            1259    16398    competencia    TABLE     h   CREATE TABLE public.competencia (
    cod_competencia_candidato integer NOT NULL,
    descricao text
);
    DROP TABLE public.competencia;
       public            postgres    false    6            �            1259    16396 )   competencia_cod_competencia_candidato_seq    SEQUENCE     �   CREATE SEQUENCE public.competencia_cod_competencia_candidato_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 @   DROP SEQUENCE public.competencia_cod_competencia_candidato_seq;
       public          postgres    false    6    199            �           0    0 )   competencia_cod_competencia_candidato_seq    SEQUENCE OWNED BY     w   ALTER SEQUENCE public.competencia_cod_competencia_candidato_seq OWNED BY public.competencia.cod_competencia_candidato;
          public          postgres    false    198            �            1259    16502    tabela_vagas    TABLE     �   CREATE TABLE public.tabela_vagas (
    cod_vagas integer NOT NULL,
    nome_vaga character varying(50) NOT NULL,
    descricao_pessoal text NOT NULL,
    competencias_exigidas text,
    local_vaga character varying(50)
);
     DROP TABLE public.tabela_vagas;
       public            postgres    false    6            �            1259    16500    tabela_vagas_cod_vagas_seq    SEQUENCE     �   CREATE SEQUENCE public.tabela_vagas_cod_vagas_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.tabela_vagas_cod_vagas_seq;
       public          postgres    false    6    205            �           0    0    tabela_vagas_cod_vagas_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.tabela_vagas_cod_vagas_seq OWNED BY public.tabela_vagas.cod_vagas;
          public          postgres    false    204            �            1259    16513    vagas_empresa    TABLE     R   CREATE TABLE public.vagas_empresa (
    cod_competencia_vagas integer NOT NULL
);
 !   DROP TABLE public.vagas_empresa;
       public            postgres    false    6            �            1259    16511 '   vagas_empresa_cod_competencia_vagas_seq    SEQUENCE     �   CREATE SEQUENCE public.vagas_empresa_cod_competencia_vagas_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.vagas_empresa_cod_competencia_vagas_seq;
       public          postgres    false    6    207            �           0    0 '   vagas_empresa_cod_competencia_vagas_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.vagas_empresa_cod_competencia_vagas_seq OWNED BY public.vagas_empresa.cod_competencia_vagas;
          public          postgres    false    206            �
           2604    16473    cadastro_empresa cod_empresa    DEFAULT     �   ALTER TABLE ONLY public.cadastro_empresa ALTER COLUMN cod_empresa SET DEFAULT nextval('public.cadastro_empresa_cod_empresa_seq'::regclass);
 K   ALTER TABLE public.cadastro_empresa ALTER COLUMN cod_empresa DROP DEFAULT;
       public          postgres    false    201    200    201            �
           2604    16487 /   candidato_competencia cod_candidato_competencia    DEFAULT     �   ALTER TABLE ONLY public.candidato_competencia ALTER COLUMN cod_candidato_competencia SET DEFAULT nextval('public.candidato_competencia_cod_candidato_competencia_seq'::regclass);
 ^   ALTER TABLE public.candidato_competencia ALTER COLUMN cod_candidato_competencia DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    16390    candidatos cod_candidato    DEFAULT     �   ALTER TABLE ONLY public.candidatos ALTER COLUMN cod_candidato SET DEFAULT nextval('public.candidatos_cod_candidato_seq'::regclass);
 G   ALTER TABLE public.candidatos ALTER COLUMN cod_candidato DROP DEFAULT;
       public          postgres    false    197    196    197            �
           2604    16401 %   competencia cod_competencia_candidato    DEFAULT     �   ALTER TABLE ONLY public.competencia ALTER COLUMN cod_competencia_candidato SET DEFAULT nextval('public.competencia_cod_competencia_candidato_seq'::regclass);
 T   ALTER TABLE public.competencia ALTER COLUMN cod_competencia_candidato DROP DEFAULT;
       public          postgres    false    199    198    199            �
           2604    16505    tabela_vagas cod_vagas    DEFAULT     �   ALTER TABLE ONLY public.tabela_vagas ALTER COLUMN cod_vagas SET DEFAULT nextval('public.tabela_vagas_cod_vagas_seq'::regclass);
 E   ALTER TABLE public.tabela_vagas ALTER COLUMN cod_vagas DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    16516 #   vagas_empresa cod_competencia_vagas    DEFAULT     �   ALTER TABLE ONLY public.vagas_empresa ALTER COLUMN cod_competencia_vagas SET DEFAULT nextval('public.vagas_empresa_cod_competencia_vagas_seq'::regclass);
 R   ALTER TABLE public.vagas_empresa ALTER COLUMN cod_competencia_vagas DROP DEFAULT;
       public          postgres    false    207    206    207            �          0    16470    cadastro_empresa 
   TABLE DATA           x   COPY public.cadastro_empresa (cod_empresa, nome, e_mail, descricao_pessoal, pais_empresa, cep, senha, cnpj) FROM stdin;
    public          postgres    false    201   �C       �          0    16484    candidato_competencia 
   TABLE DATA           J   COPY public.candidato_competencia (cod_candidato_competencia) FROM stdin;
    public          postgres    false    203   �D       �          0    16387 
   candidatos 
   TABLE DATA           �   COPY public.candidatos (cod_candidato, nome, sobrenome, data_de_nascimento, e_mail, cpf, pais, cep, descricao_pessoal, senha) FROM stdin;
    public          postgres    false    197   �D       �          0    16398    competencia 
   TABLE DATA           K   COPY public.competencia (cod_competencia_candidato, descricao) FROM stdin;
    public          postgres    false    199   /F       �          0    16502    tabela_vagas 
   TABLE DATA           r   COPY public.tabela_vagas (cod_vagas, nome_vaga, descricao_pessoal, competencias_exigidas, local_vaga) FROM stdin;
    public          postgres    false    205   LF       �          0    16513    vagas_empresa 
   TABLE DATA           >   COPY public.vagas_empresa (cod_competencia_vagas) FROM stdin;
    public          postgres    false    207   iF       �           0    0     cadastro_empresa_cod_empresa_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.cadastro_empresa_cod_empresa_seq', 1, false);
          public          postgres    false    200            �           0    0 3   candidato_competencia_cod_candidato_competencia_seq    SEQUENCE SET     b   SELECT pg_catalog.setval('public.candidato_competencia_cod_candidato_competencia_seq', 1, false);
          public          postgres    false    202            �           0    0    candidatos_cod_candidato_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.candidatos_cod_candidato_seq', 1, true);
          public          postgres    false    196            �           0    0 )   competencia_cod_competencia_candidato_seq    SEQUENCE SET     X   SELECT pg_catalog.setval('public.competencia_cod_competencia_candidato_seq', 1, false);
          public          postgres    false    198            �           0    0    tabela_vagas_cod_vagas_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.tabela_vagas_cod_vagas_seq', 1, false);
          public          postgres    false    204            �           0    0 '   vagas_empresa_cod_competencia_vagas_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.vagas_empresa_cod_competencia_vagas_seq', 1, false);
          public          postgres    false    206                       2606    16478 &   cadastro_empresa cadastro_empresa_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.cadastro_empresa
    ADD CONSTRAINT cadastro_empresa_pkey PRIMARY KEY (cod_empresa);
 P   ALTER TABLE ONLY public.cadastro_empresa DROP CONSTRAINT cadastro_empresa_pkey;
       public            postgres    false    201                       2606    16489 0   candidato_competencia candidato_competencia_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.candidato_competencia
    ADD CONSTRAINT candidato_competencia_pkey PRIMARY KEY (cod_candidato_competencia);
 Z   ALTER TABLE ONLY public.candidato_competencia DROP CONSTRAINT candidato_competencia_pkey;
       public            postgres    false    203                        2606    16395    candidatos candidatos_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.candidatos
    ADD CONSTRAINT candidatos_pkey PRIMARY KEY (cod_candidato);
 D   ALTER TABLE ONLY public.candidatos DROP CONSTRAINT candidatos_pkey;
       public            postgres    false    197                       2606    16416    competencia competencia_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.competencia
    ADD CONSTRAINT competencia_pkey PRIMARY KEY (cod_competencia_candidato);
 F   ALTER TABLE ONLY public.competencia DROP CONSTRAINT competencia_pkey;
       public            postgres    false    199                       2606    16510    tabela_vagas tabela_vagas_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tabela_vagas
    ADD CONSTRAINT tabela_vagas_pkey PRIMARY KEY (cod_vagas);
 H   ALTER TABLE ONLY public.tabela_vagas DROP CONSTRAINT tabela_vagas_pkey;
       public            postgres    false    205            
           2606    16518     vagas_empresa vagas_empresa_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.vagas_empresa
    ADD CONSTRAINT vagas_empresa_pkey PRIMARY KEY (cod_competencia_vagas);
 J   ALTER TABLE ONLY public.vagas_empresa DROP CONSTRAINT vagas_empresa_pkey;
       public            postgres    false    207                       2606    16490 J   candidato_competencia candidato_competencia_cod_candidato_competencia_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato_competencia
    ADD CONSTRAINT candidato_competencia_cod_candidato_competencia_fkey FOREIGN KEY (cod_candidato_competencia) REFERENCES public.competencia(cod_competencia_candidato);
 t   ALTER TABLE ONLY public.candidato_competencia DROP CONSTRAINT candidato_competencia_cod_candidato_competencia_fkey;
       public          postgres    false    203    2818    199                       2606    16495 K   candidato_competencia candidato_competencia_cod_candidato_competencia_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.candidato_competencia
    ADD CONSTRAINT candidato_competencia_cod_candidato_competencia_fkey1 FOREIGN KEY (cod_candidato_competencia) REFERENCES public.candidatos(cod_candidato);
 u   ALTER TABLE ONLY public.candidato_competencia DROP CONSTRAINT candidato_competencia_cod_candidato_competencia_fkey1;
       public          postgres    false    2816    203    197                       2606    16519 6   vagas_empresa vagas_empresa_cod_competencia_vagas_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.vagas_empresa
    ADD CONSTRAINT vagas_empresa_cod_competencia_vagas_fkey FOREIGN KEY (cod_competencia_vagas) REFERENCES public.tabela_vagas(cod_vagas);
 `   ALTER TABLE ONLY public.vagas_empresa DROP CONSTRAINT vagas_empresa_cod_competencia_vagas_fkey;
       public          postgres    false    207    205    2824                       2606    16524 7   vagas_empresa vagas_empresa_cod_competencia_vagas_fkey1    FK CONSTRAINT     �   ALTER TABLE ONLY public.vagas_empresa
    ADD CONSTRAINT vagas_empresa_cod_competencia_vagas_fkey1 FOREIGN KEY (cod_competencia_vagas) REFERENCES public.cadastro_empresa(cod_empresa);
 a   ALTER TABLE ONLY public.vagas_empresa DROP CONSTRAINT vagas_empresa_cod_competencia_vagas_fkey1;
       public          postgres    false    2820    207    201            �   
  x�u�;N�0�z|��`�b�!jh�hf���Z'�YD�C�A�b8,U,�5������:�^wc�:��4�EJX�T�p�	��� dk�mA*F˛z;�6L�:`��4�n�9��/��E�Lִ�2�2z��bp��j�0�)�y�g�8,芦tS��՜�7��#f,oG���ɏ�c�i/�)W�zx�'P��֔ ����Zm\0O=#uy�p�Ƽ�vaN9.���W�:wq.4Ӻ��֫�,�m-^�B��vk�z`�� ����      �      x������ � �      �   P  x�]QKj�0]�N�8Ȓ�X��H)m��.e���R[d���tQ�5r���p�C��dp>�C׻���bt���2�e�Y���s���E�,�Ԃ�J���F'��w���䲔p�a���%��~K2�����Æ�Id2Uv��i�aK�M�,m��u�%�e>�r�u�:`@h�:�{:1�6�2��/���3��$�%<`�z@�bn�#�-���8�0pSS��c�F�frn�3\EZoq3���2z�
�C��iX���$R7u��-��RXeD׼	|�S_PIiRɁ4�\��/39���$�������0��{���������Mc`�B��M�-      �      x������ � �      �      x������ � �      �      x������ � �     