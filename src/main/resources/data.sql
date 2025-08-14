
-- Users
INSERT INTO users(id, username, password) VALUES
('b0d8edfe-53d8-40dd-a323-8e9d8f42b3a2', 'david', '$2a$10$jJx/r1TV8kohq4JlYgWhbuuZPbDKmddUgKFMwnm6ziErIb6A9NJQ.');

-- Main Tasks
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('620db693-a211-4176-9380-769f51615fa0', 'Organizar documentos do escritório', 'Separar, categorizar e arquivar todos os documentos do escritório', '2025-08-22', 'PENDING', 'MEDIUM', NULL),
('2faaadb1-ac8b-4bb6-8029-9b229f0811f3', 'Preparar apresentação do projeto', 'Criar slides e revisar o conteúdo para a reunião de sexta-feira', '2025-08-17', 'IN_PROGRESS', 'HIGH', NULL),
('dbe74aa3-febd-4b84-b565-86a3441d6996', 'Planejar viagem de férias', 'Escolher destino, reservar passagens e hospedagem', '2025-09-11', 'PENDING', 'MEDIUM', NULL),
('5242015f-04f3-4b12-9406-9d3321cacb6d', 'Revisar código do módulo financeiro', 'Realizar code review e apontar melhorias no módulo financeiro', '2025-08-15', 'PENDING', 'HIGH', NULL),
('e9329889-5769-4cf8-8874-fda012337c32', 'Atualizar inventário de equipamentos', 'Listar todos os equipamentos da empresa e atualizar o sistema', '2025-08-27', 'PENDING', 'LOW', NULL);

-- Subtasks of "Organizar documentos do escritório"
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('d65f6346-0c9f-422f-8590-b929eee0593d', 'Separar documentos fiscais', 'Identificar e separar notas fiscais e recibos', '2025-08-16', 'IN_PROGRESS', 'MEDIUM', '620db693-a211-4176-9380-769f51615fa0'),
('b1701ae1-6a6d-4c7d-ab7c-56edd9e344de', 'Arquivar contratos', 'Organizar todos os contratos em pastas corretas', '2025-08-18', 'PENDING', 'MEDIUM', '620db693-a211-4176-9380-769f51615fa0');

-- Subtasks of "Preparar apresentação do projeto"
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('8ac0ca79-3794-432b-8162-ed1dbc931f88', 'Criar slides de introdução', 'Fazer a primeira parte da apresentação com visão geral do projeto', '2025-08-14', 'COMPLETED', 'HIGH', '2faaadb1-ac8b-4bb6-8029-9b229f0811f3'),
('99d810ff-08a4-42fe-b67d-3f7e3629bf83', 'Revisar dados do relatório', 'Checar e atualizar gráficos e métricas', '2025-08-15', 'IN_PROGRESS', 'HIGH', '2faaadb1-ac8b-4bb6-8029-9b229f0811f3'),
('49f1bd09-ac5b-47d1-a7bb-c134385366b1', 'Adicionar conclusões e próximos passos', 'Finalizar a apresentação com as recomendações', '2025-08-16', 'PENDING', 'HIGH', '2faaadb1-ac8b-4bb6-8029-9b229f0811f3');

-- Subtasks of "Planejar viagem de férias"
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('c32d4bd8-df3f-4d57-9449-1c26de4bc31e', 'Pesquisar destinos possíveis', 'Pesquisar opções de viagem considerando custo-benefício', '2025-08-19', 'COMPLETED', 'LOW', 'dbe74aa3-febd-4b84-b565-86a3441d6996'),
('46e0bd03-55d2-4450-afd1-34023155b884', 'Reservar hospedagem', 'Escolher e reservar hotel ou pousada', '2025-09-01', 'PENDING', 'MEDIUM', 'dbe74aa3-febd-4b84-b565-86a3441d6996'),
('04b7a1af-06c2-4ed7-bbab-68def0286fb9', 'Comprar passagens', 'Comprar passagens aéreas com melhores preços', '2025-08-28', 'PENDING', 'HIGH', 'dbe74aa3-febd-4b84-b565-86a3441d6996');

-- Subtasks of "Revisar código do módulo financeiro"
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('651ffc5d-be88-4816-b8c5-cf9fd0054348', 'Verificar regras de negócio', 'Checar se as validações estão corretas no backend', '2025-08-13', 'IN_PROGRESS', 'HIGH', '5242015f-04f3-4b12-9406-9d3321cacb6d'),
('d23d06d3-ded2-4edc-9309-b21c20235169', 'Testar integração com API de pagamentos', 'Executar testes automatizados para confirmar funcionamento', '2025-08-14', 'PENDING', 'HIGH', '5242015f-04f3-4b12-9406-9d3321cacb6d'),
('609f9d07-3489-46db-ad80-47e0ad8dd884', 'Revisar performance de queries SQL', 'Analisar lentidão e otimizar consultas', '2025-08-15', 'PENDING', 'MEDIUM', '5242015f-04f3-4b12-9406-9d3321cacb6d');

-- Subtasks of "Atualizar inventário de equipamentos"
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('bc062a09-bc9e-4805-8398-6b870c1e5654', 'Checar computadores', 'Verificar todos os computadores e registrar no sistema', '2025-08-17', 'IN_PROGRESS', 'LOW', 'e9329889-5769-4cf8-8874-fda012337c32'),
('226d1018-b0db-4f62-9bcb-4825525e8c4b', 'Inventariar impressoras', 'Registrar modelos e estado das impressoras', '2025-08-20', 'PENDING', 'LOW', 'e9329889-5769-4cf8-8874-fda012337c32'),
('65b9f8ba-7a1a-480b-b6dc-51e813f35704', 'Verificar periféricos', 'Checar mouses, teclados e outros acessórios', '2025-08-18', 'PENDING', 'LOW', 'e9329889-5769-4cf8-8874-fda012337c32');

-- More tasks
INSERT INTO task (id, title, description, due_date, status, priority, parent_task_fk) VALUES
('b3dec252-8788-40a4-8c68-5ca80704bfd3', 'Organizar evento de integração', 'Planejar local, comida e atividades para equipe', '2025-09-05', 'PENDING', 'MEDIUM', NULL),
('9a33916f-daeb-405c-953b-fd2d9b6c544a', 'Realizar backup dos servidores', 'Efetuar backup completo e armazenar em nuvem segura', '2025-08-25', 'PENDING', 'HIGH', NULL),
('8d25ba45-0bfd-464a-a5e0-1ffb3f48f6bf', 'Treinar novos colaboradores', 'Apresentar sistemas e processos internos', '2025-09-02', 'IN_PROGRESS', 'MEDIUM', NULL);
